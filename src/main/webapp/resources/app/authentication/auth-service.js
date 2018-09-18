var app = require('../app');

var authService = function($http) {

	this.getRoles = function() {

		return $http({
			method : 'GET',
			url : '/profile/roles'
		});
	};

	this.logout = function() {
		$http({
			method : 'POST',
			url : '/logout'
		}).then(function(response) {
			if (response.status == 200) {
				window.location.reload();
			} else {
				console.log("Logout failed!");
			}
		});
	};
}

app.service('authService', [ '$http', authService ]);