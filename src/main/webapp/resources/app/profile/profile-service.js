var app = require('../app');

var profileService = function($http) {

	this.social = {
		works : 'HardCoded LLC',
		lives : 'Hardcoded BIH',
		birthday : new Date('1987-05-03T05:00:00.000Z'),
		from : 'Gracanica'
	};

	this.getProfileBasicInfo = function() {
		var data = {
			userName : undefined
		};

		var successCallback = function(response) {
			data.userName = response.data.toString();
		};

		var errorCallback = function(error) {
			console.log("Error called from dataService getProfileBasicInfo");
			console.log(error);
		};

		$http({
			method : 'GET',
			url : '/profile/username'
		}).then(successCallback, errorCallback);

		return data;
	};

};

var proto = profileService.prototype;

proto.getSocialData = function() {
	return this.social;
};

app.service('profileService', [ '$http', profileService ]);