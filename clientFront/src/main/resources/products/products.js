angular.module('app').controller('indexController', function ($scope, $http) {
    //const contextPath = 'http://localhost:8189/summer/api/v1';

    $scope.loadPage = function (pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                'p': pageIndex
            }
        }).then(function (response) {
            $scope.productsPage = response.data;
            console.log(response.data);
        });
    };

    $scope.loadPage();

});