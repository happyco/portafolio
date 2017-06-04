'use strict';
module.exports = function() {
    this.loginPage = require('/features/step_definitions/aloginPage.js');
    this.Given(/^I go to "([^"]*)"$/, function(site, callback) {
        // Write code here that turns the phrase above into concrete actions
        this.loginPage.go(site)
            .then(callback);

    });

    this.When(/^I type "([^"]*)" user$/, function(callback, user) {
        // Write code here that turns the phrase above into concrete actions
        this.loginPage.setUser(user).then(function(){
            callback();
        });
    });

    this.And(/^I type "([^"]*)" password$/, function(callback, password) {
        // Write code here that turns the phrase above into concrete actions
        this.loginPage.setUser(password).then(function(){
            callback();
        });
    });

    this.And(/^I login$/, function(callback) {
        // Write code here that turns the phrase above into concrete actions
        this.loginPage.clickbtn().then(function(){
            callback();
        });
    });


    this.Then(/^I should see an error message$/, function(callback) {
        // Write code here that turns the phrase above into concrete actions
        this.loginPage.emsj();
        callback(null, 'pending');
    });
};