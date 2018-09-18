var app = require('../app');

var entriesController = function($scope, $state, $window, dataService, profileService, toastr) {
	
	$scope.user = angular.copy(dataService.getUserData());
	$scope.basicInfo = profileService.getProfileBasicInfo();
	$scope.social = profileService.getSocialData();

	$scope.saveUser = function() {
		var validData = true;
		
		Object.entries($scope.user).forEach(([key, value]) => {
		   if(value === undefined && key !== 'userId') {
			   validData = false;
		   }
		});
		
		if(validData){
			var successCallback = function(response) {
				toastr["success"]("User with ID: " + response.data.userId
						+ " saved successfully");
				$state.go("userList", {}, {
					reload : true
				});
			};
	
			var errorCallback = function(error) {
				console.log(error);
				toastr["error"]("Something went wrong");
			};
	
			dataService.saveUser($scope.user).then(successCallback, errorCallback);
		}
		else {
			toastr["warning"]("Data are not valid");
		}
	};

	$scope.editUser = function() {
		var successCallback = function(response) {
			dataService.removeExistingUserDataAfterEdit();
			toastr["success"]("User with ID: " + response.data.userId
					+ " edited successfully");
			$state.go("userList", {}, {
				reload : true
			});
		};

		var errorCallback = function(error) {
			console.log(error);
			toastr["error"]("Something went wrong");
		};

		dataService.editUser($scope.user).then(successCallback, errorCallback);
	};
};

app.controller("entriesController", [ '$scope', '$state', '$window',
		'dataService', 'profileService', 'toastr', entriesController ]);

module.exports = app;