var app = require('../app');

var dataService = function($http) {

	this.userData = {
		userId : undefined,
		firstName : undefined,
		lastName : undefined,
		email : undefined
	};

	this.getUsers = function() {
		var data = {
			users : undefined,
			error : undefined
		};

		var successCallback = function(response) {
			data.users = response.data;
		};

		var errorCallback = function(error) {
			data.error = error;
		};

		$http({
			method : 'GET',
			url : '/user/list'
		}).then(successCallback, errorCallback);

		return data;
	};

	this.deleteUser = function(data) {
		return $http({
			method : 'DELETE',
			url : '/user/delete/' + data.userId
		});
	};

	this.saveUser = function(data) {
		return $http({
			method : 'POST',
			url : '/user/callForSave',
			data : data
		});
	};

	this.editUser = function(data) {
		return $http({
			method : 'PUT',
			url : '/user/callForUpdate',
			data : data
		});
	};

};

var proto = dataService.prototype;

proto.getUserData = function() {
	
	return this.userData;

};

proto.removeExistingUserDataAfterEdit = function() {
	this.userData.userId = undefined;
	this.userData.firstName = undefined;
	this.userData.lastName = undefined;
	this.userData.email = undefined;
};

proto.setExistingUserData = function(data) {
	this.userData.userId = data.userId;
	this.userData.firstName = data.firstName;
	this.userData.lastName = data.lastName;
	this.userData.email = data.email;
};

app.service('dataService', [ '$http', dataService ]);