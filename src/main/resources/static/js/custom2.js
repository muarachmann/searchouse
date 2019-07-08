jQuery(document).ready(function() {
	
	"use strict";

	// toggle between user and agent registration forms

	$("#toggleUserRegistration").click(function(){
		var isAgentActive = $('#agent_user_type');
		if($("#userRegistrationForm").hasClass("hidden")){
			$("#userRegistrationForm").removeClass("hidden").show("fade");
			$("#agentRegistrationForm").addClass("hidden").hide("fade");
			$(this).addClass("active"); $("#toggleAgentRegistration").removeClass("active");
			$("#userTypeUser").append('<input type="hidden" id="normal_user_type" value="user" name="user_type"/>');
		}
		if(isAgentActive.length){isAgentActive.remove();}
	});

	$("#toggleAgentRegistration").click(function(){
		var isUserActive = $('#normal_user_type');
		if($("#agentRegistrationForm").hasClass("hidden")){
			$("#agentRegistrationForm").removeClass("hidden").show("fade") ;
			$("#userRegistrationForm").addClass("hidden").hide("fade");
			$(this).addClass("active"); $("#toggleUserRegistration").removeClass("active");
			$("#userTypeAgent").append('<input type="hidden" id="agent_user_type" value="agent" name="user_type"/>');
		}
		if(isUserActive.length){isUserActive.remove();}
	});

});