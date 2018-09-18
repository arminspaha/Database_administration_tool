var appLogin = require('../app-login');

var loginController = function($scope, $timeout) {
	
	$scope.isDisabled = true;
	
};


appLogin.controller("loginController", ['$scope', '$timeout', loginController]);

module.exports = appLogin;