var app = require('../app');

app.directive('trRow', function() {
	return {
		restrict : 'EA',
		templateUrl : './resources/app/view/templates/tr-row.html',
		controller : [ '$scope', '$state', '$timeout', 'dataService', 'authService', 'toastr', function($scope, $state, $timeout, dataService, authService, toastr) {
			$scope.editUser = function(user) {
				dataService.setExistingUserData(user);
				$timeout(() => {
					$state.go("entries", {}, {reload: true});
				});
			};
			$scope.deleteUser = function(user) {
				
				var successCallback = function(response) {
					toastr["success"]("User with ID: " + response.data.userId + " deleted successfully");
					$state.go("userList", {}, {reload: true});
				};

				var errorCallback = function(error) {
					toastr["error"](error.data.message);
					$state.go("userList", {}, {reload: true});
				};
				
				dataService.deleteUser(user)
				.then(successCallback, errorCallback);
			};
			
			$scope.roles = authService.getRoles();
		} ]
	};
});

module.exports = app;