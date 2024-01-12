var app = angular.module('userApp', ['ngRoute']);

app.controller('UserController', ['$scope', '$routeParams', '$http', function ($scope, $routeParams, $http) {

    $scope.users = [];
    $scope.filter = { name: '', email: '' };
    $scope.currentPage = 0;
    $scope.numberOfPages = 1;
    $scope.showDetails = false;
    $scope.selectedUser = {};
    $scope.newUser = {
        name: "",
        email: "",
        password: "",
        selectedProfile: null
    };
    $scope.newProfile = {};
    $scope.profiles = [];

    $scope.isEditMode = false;

    $scope.submitSearch = function () {
        $scope.loadUsers();
    };

    $scope.clearFilter = function () {
        $scope.filter.name = '';
        $scope.filter.email = '';
        $scope.loadUsers();
    };

    $scope.loadUsers = function () {
        var baseUrl = 'http://localhost:8084/api/v1/user/';
        var endpoint = 'getUserList';
    
        
        if ($scope.filter.name && !$scope.filter.email) {
            endpoint = 'getUserByName';
        }
    
        if (!$scope.filter.name && $scope.filter.email) {
            endpoint = 'getUserByEmail';
        }
    
        var url = baseUrl + endpoint;
        var params = { name: $scope.filter.name, email: $scope.filter.email, size: 10, page: $scope.currentPage };
    
        $http.get(url, { params: params })
            .then(function (response) {
                $scope.users = response.data.content;
                $scope.users.forEach(function (user) {
                    if (user.profile) {
                        user.profileName = user.profile.name;
                    }
                });
                $scope.numberOfPages = response.data.totalPages;
            })
            .catch(function (error) {
                console.error('Erro ao carregar usuários:', error);
            });
    };

    $scope.loadProfiles = function () {
        var profilesUrl = 'http://localhost:8084/api/v1/profile/getAllProfile';

        $http.get(profilesUrl)
            .then(function (response) {
                $scope.profiles = response.data;
            })
            .catch(function (error) {
                console.error('Erro ao carregar perfis:', error);
            });
    };

    $scope.loadProfiles();

    $scope.loadUsers();

    $scope.nextPage = function () {
        $scope.currentPage++;
        $scope.loadUsers();
    };

    $scope.prevPage = function () {
        $scope.currentPage--;
        $scope.loadUsers();
    };

    $scope.closeDetails = function () {
        $scope.showDetails = false;
        $scope.selectedUser = {};
    };

    $scope.deleteUser = function (userId) {
        console.log('Excluindo usuário com ID:', userId);
        $http({
            method: 'DELETE',
            url: '/api/v1/user/deleteUser/' + $scope.selectedUser.id
        })
        .then(function (response) {
            console.log('Usuário excluído com sucesso:', response.data);
        })
        .catch(function (error) {
            console.error('Erro ao excluir usuário:', error);
        });
        $scope.loadUsers();
    };

    $scope.saveNewUser = function () {
        if ($scope.isEditMode) {
            $scope.saveEditedUser();
        } else {
            console.log($scope.newUser.selectedProfile);
            if ($scope.newUser.selectedProfile) {
                $scope.newUser.profile = {
                    id: $scope.newUser.selectedProfile.id,
                    name: $scope.newUser.selectedProfile.name
                };
                $http({
                    method: 'POST',
                    url: '/api/v1/user/save',
                    data: {
                        name: $scope.newUser.name,
                        email: $scope.newUser.email,
                        password: $scope.newUser.password,
                        profile: $scope.newUser.profile
                    }
                })
                .then(function (response) {
                    console.log('Novo usuário criado com sucesso:', response.data);
                })
                .catch(function (error) {
                    console.error('Erro ao criar novo usuário:', error);
                });
            } else {
                console.error('Campos obrigatórios não preenchidos.');
            }
        }
    };

    $scope.editUser = function (userId) {
        var detailsUrl = 'http://localhost:8084/api/v1/user/' + userId;

        $http.get(detailsUrl)
            .then(function (response) {
                $scope.selectedUser = response.data;
                $scope.newUser.name = $scope.selectedUser.name;
                $scope.newUser.email = $scope.selectedUser.email;
                $scope.newUser.password = $scope.selectedUser.password;
                $scope.newUser.selectedProfile = $scope.selectedUser.profile;

                // Ativar o modo de edição
                $scope.isEditMode = true;
            })
            .catch(function (error) {
                console.error('Erro ao carregar detalhes do usuário:', error);
            });
    };

    $scope.saveEditedUser = function () {
        // Enviar uma requisição PUT para atualizar o usuário
        $http({
            method: 'PUT',
            url: 'http://localhost:8084/api/v1/user/update',
            data: {
                id: $scope.selectedUser.id,
                name: $scope.newUser.name,
                email: $scope.newUser.email,
                password: $scope.newUser.password,
                profile: $scope.newUser.selectedProfile
            }
        })
        .then(function (response) {
            console.log('Usuário editado com sucesso:', response.data);
            $scope.isEditMode = false; // Desativar o modo de edição
            $scope.loadUsers(); // Recarregar a lista de usuários
        })
        .catch(function (error) {
            console.error('Erro ao editar usuário:', error);
        });
    };

    $scope.saveChanges = function () {
        $http({
            method: 'PUT',
            url: '/api/v1/user/update',
            data: {
                id: $scope.selectedUser.id,
                name: $scope.selectedUser.name,
                email: $scope.selectedUser.email,
                password: $scope.selectedUser.password,
                profile: { name: $scope.selectedUser.profile.name }
            }
        })
        .then(function (response) {
            console.log('Alterações salvas com sucesso:', response.data);
        })
        .catch(function (error) {
            console.error('Erro ao salvar alterações:', error);
        });
    };

    $scope.createProfile = function () {
        var profilesUrl = 'http://localhost:8084/api/v1/profile/save';

        $http.post(profilesUrl, $scope.newProfile)
            .then(function (response) {
                console.log('Novo perfil criado com sucesso:', response.data);
                $scope.loadProfiles();
            })
            .catch(function (error) {
                console.error('Erro ao criar novo perfil:', error);
            });
    };

}]);
