Feature: SiriusXM AIVA
	
	Scenario: Prepare ENV for UDE chat
  	Given I use Chrome browser for Chat	
   	Given I launch URL "http://anvil.tellme.com/~keskumar/ude/#start"
   	
   	Scenario: Validate UDE Chat widget UI
   	Given Button Chat is accepted and connected to agent
   	Then Validate the UI
	
	Scenario: SXM Cancel_Subscription_to_Transfer to Cancel_Phone_Options No Flow with FeedBack Form
	Then Validate AIVA Responses "Hi, I'm the Sirius XM Virtual Agent. I'm here for you!"
	Then Validate AIVA Responses "May I have your first and last name?"
	Then User message is sent successfully ".Keshav Kumar"
	Then Validate AIVA Responses "Thanks, may I also have your phone number, including your area code?"
	Then User message is sent successfully ".9964202472"
	Then Validate AIVA Responses "Thanks, again."
	Then Validate AIVA Responses "How can I help you?"
	Then User message is sent successfully ".I want to cancel my subscription"
	Then Validate AIVA Responses "Okay, I may be able to help you with that."
	Then Validate AIVA Responses "May I ask why you wish to cancel your subscription?"
	Then User message is sent successfully ".TestMessageabc"
	Then Validate AIVA Responses "Chat specialists cannot cancel subscriptions. To cancel your subscription, you must call 888-601-6302."
	Then Validate AIVA Responses "Is there anything else you wish to chat about today?"
	Then Select Quick Response "No"
	Then Validate AIVA Responses "Did that help?"
	Then Select Quick Response "No"
	Then Submit the FeedBack Form
	Then Validate AIVA Responses "Thanks, again."
	Then Validate the AIVA responses "SXM Cancel_Subscription_to_Transfer to Cancel_Phone_Options No Flow with FeedBack Form"
	Then Reinitiate the chat window for other scenario

Scenario: SXM Cancel_Subscription_to_Transfer to Cancel_Phone_Options No Flow with Survey
	Then Validate AIVA Responses "Hi, I'm the Sirius XM Virtual Agent. I'm here for you!"
	Then Validate AIVA Responses "May I have your first and last name?"
	Then User message is sent successfully ".Keshav Kumar"
	Then Validate AIVA Responses "Thanks, may I also have your phone number, including your area code?"
	Then User message is sent successfully ".9964202472"
	Then Validate AIVA Responses "Thanks, again."
	Then Validate AIVA Responses "How can I help you?"
	Then User message is sent successfully ".I want to cancel my subscription"
	Then Validate AIVA Responses "Okay, I may be able to help you with that."
	Then Validate AIVA Responses "May I ask why you wish to cancel your subscription?"
	Then User message is sent successfully ".TestMessageabc"
	Then Validate AIVA Responses "Chat specialists cannot cancel subscriptions. To cancel your subscription, you must call 888-601-6302."
	Then Validate AIVA Responses "Is there anything else you wish to chat about today?"
	Then Select Quick Response "No"
	Then Validate AIVA Responses "Did that help?"
	Then Select Quick Response "Yes"
	Then Submit the Post Chat Survey
	Then Validate AIVA Responses "Thanks, again."
	Then Validate the AIVA responses "SXM Cancel_Subscription_to_Transfer to Cancel_Phone_Options No Flow with Survey"
	Then Reinitiate the chat window for other scenario


	Scenario: SXM Cancel_Subscription_to_Transfer to Cancel_Transfer_Vague Yes Flow
	Then Validate AIVA Responses "Hi, I'm the Sirius XM Virtual Agent. I'm here for you!"
	Then Validate AIVA Responses "May I have your first and last name?"
	Then User message is sent successfully ".Keshav Kumar"
	Then Validate AIVA Responses "Thanks, may I also have your phone number, including your area code?"
	Then User message is sent successfully ".9964202472"
	Then Validate AIVA Responses "Thanks, again."
	Then Validate AIVA Responses "How can I help you?"
	Then User message is sent successfully ".I want to cancel my subscription"
	Then Validate AIVA Responses "Okay, I may be able to help you with that."
	Then Validate AIVA Responses "May I ask why you wish to cancel your subscription?"
	Then User message is sent successfully ".I sold my old car."
	Then Validate AIVA Responses "Are you getting a new (or "new to you") car with a SiriusXM radio?"
	Then User message is sent successfully ".Yes, Planning for a new car"
	Then Validate AIVA Responses "We can transfer your existing SiriusXM service from your old vehicle to your new one. If your new vehicle includes a trial subscription, your existing service will automatically resume when the trial period ends."
	Then Validate AIVA Responses "I'll connect you with a Loyal Listener Specialist who can complete this for you."
	Then Validate the AIVA responses "SXM Cancel_Subscription_to_Transfer to Cancel_Transfer_Vague Yes Flow"
	Then Reinitiate the chat window for other scenario

	Scenario: SXM Cancel_Subscription_to_Transfer to Cancel_Transfer_Vague No Flow
	Then Validate AIVA Responses "Hi, I'm the Sirius XM Virtual Agent. I'm here for you!"
	Then Validate AIVA Responses "May I have your first and last name?"
	Then User message is sent successfully ".Keshav Kumar"
	Then Validate AIVA Responses "Thanks, may I also have your phone number, including your area code?"
	Then User message is sent successfully ".9964202472"
	Then Validate AIVA Responses "Thanks, again."
	Then Validate AIVA Responses "How can I help you?"
	Then User message is sent successfully ".I want to cancel my subscription"
	Then Validate AIVA Responses "Okay, I may be able to help you with that."
	Then Validate AIVA Responses "May I ask why you wish to cancel your subscription?"
	Then User message is sent successfully ".I sold my old car."
	Then Validate AIVA Responses "Are you getting a new (or "new to you") car with a SiriusXM radio?"
	Then User message is sent successfully ".No"
	Then Validate AIVA Responses "We hope you enjoyed SiriusXM. I'll connect you with a Loyal Listener Specialist who can help you cancel your subscription."
	Then Validate the AIVA responses "SXM Cancel_Subscription_to_Transfer to Cancel_Transfer_Vague No Flow"
	Then Reinitiate the chat window for other scenario


	Scenario: SXM Cancel_Subscription_to_Transfer to Cancel_Transfer_Vague2 Yes Flow
	Then Validate AIVA Responses "Hi, I'm the Sirius XM Virtual Agent. I'm here for you!"
	Then Validate AIVA Responses "May I have your first and last name?"
	Then User message is sent successfully ".Keshav Kumar"
	Then Validate AIVA Responses "Thanks, may I also have your phone number, including your area code?"
	Then User message is sent successfully ".9964202472"
	Then Validate AIVA Responses "Thanks, again."
	Then Validate AIVA Responses "How can I help you?"
	Then User message is sent successfully ".I want to cancel my subscription"
	Then Validate AIVA Responses "Okay, I may be able to help you with that."
	Then Validate AIVA Responses "May I ask why you wish to cancel your subscription?"
	Then User message is sent successfully ".I bought a new/used car"
	Then Validate AIVA Responses "Does it have a SiriusXM radio?"
	Then User message is sent successfully ".Yes, i have"
	Then Validate AIVA Responses "We can transfer your existing SiriusXM service from your old vehicle to your new one. If your new vehicle includes a trial subscription, your existing service will automatically resume when the trial period ends."
	Then Validate AIVA Responses "I'll connect you with a Loyal Listener Specialist who can complete this for you."
	Then Validate the AIVA responses "SXM Cancel_Subscription_to_Transfer to Cancel_Transfer_Vague2 Yes Flow"
	Then Reinitiate the chat window for other scenario


	Scenario: SXM Cancel_Subscription_to_Transfer to Cancel_Transfer_Vague2 No Flow
	Then Validate AIVA Responses "Hi, I'm the Sirius XM Virtual Agent. I'm here for you!"
	Then Validate AIVA Responses "May I have your first and last name?"
	Then User message is sent successfully ".Keshav Kumar"
	Then Validate AIVA Responses "Thanks, may I also have your phone number, including your area code?"
	Then User message is sent successfully ".9964202472"
	Then Validate AIVA Responses "Thanks, again."
	Then Validate AIVA Responses "How can I help you?"
	Then User message is sent successfully ".I want to cancel my subscription"
	Then Validate AIVA Responses "Okay, I may be able to help you with that."
	Then Validate AIVA Responses "May I ask why you wish to cancel your subscription?"
	Then User message is sent successfully ".I bought a new/used car"
	Then Validate AIVA Responses "Does it have a SiriusXM radio?"
	Then User message is sent successfully ".Nope"
	Then Validate AIVA Responses "We hope you enjoyed SiriusXM. I'll connect you with a Loyal Listener Specialist who can help you cancel your subscription."
	Then Validate the AIVA responses "SXM Cancel_Subscription_to_Transfer to Cancel_Transfer_Vague2 No Flow"
	Then Reinitiate the chat window for other scenario


	Scenario: SXM Cancel_Subscription_to_Transfer to Cancel_Phone_Options Yes Flow
	Then Validate AIVA Responses "Hi, I'm the Sirius XM Virtual Agent. I'm here for you!"
	Then Validate AIVA Responses "May I have your first and last name?"
	Then User message is sent successfully ".Keshav Kumar"
	Then Validate AIVA Responses "Thanks, may I also have your phone number, including your area code?"
	Then User message is sent successfully ".9964202472"
	Then Validate AIVA Responses "Thanks, again."
	Then Validate AIVA Responses "How can I help you?"
	Then User message is sent successfully ".I want to cancel my subscription"
	Then Validate AIVA Responses "Okay, I may be able to help you with that."
	Then Validate AIVA Responses "May I ask why you wish to cancel your subscription?"
	Then User message is sent successfully ".TestMessageabc"
	Then Validate AIVA Responses "Chat specialists cannot cancel subscriptions. To cancel your subscription, you must call 888-601-6302."
	Then Validate AIVA Responses "Is there anything else you wish to chat about today?"
	Then Select Quick Response "Yes"
	Then Validate AIVA Responses "Great, I'll connect you now."
	Then Validate the AIVA responses "SXM Cancel_Subscription_to_Transfer to Cancel_Phone_Options Yes Flow"
	Then Reinitiate the chat window for other scenario
	
	
	
	

	
	Scenario: SXM Cancel_Subscription_to_Transfer to Suspend_Phone_Options No Flow with Survey
	Then Validate AIVA Responses "Hi, I'm the Sirius XM Virtual Agent. I'm here for you!"
	Then Validate AIVA Responses "May I have your first and last name?"
	Then User message is sent successfully ".Keshav Kumar"
	Then Validate AIVA Responses "Thanks, may I also have your phone number, including your area code?"
	Then User message is sent successfully ".9964202472"
	Then Validate AIVA Responses "Thanks, again."
	Then Validate AIVA Responses "How can I help you?"
	Then User message is sent successfully ".I want to suspend my subscription"
	Then Validate AIVA Responses "Chat specialists cannot suspend/hold subscriptions. To suspend your subscription, you must call 888-601-6302."
	Then Validate AIVA Responses "Is there anything else you wish to chat about today?"
	Then Select Quick Response "No"
	Then Validate AIVA Responses "Did that help?"
	Then Select Quick Response "Yes"
	Then Submit the Post Chat Survey
	Then Validate AIVA Responses "Thanks, again."
	Then Validate the AIVA responses "SXM Cancel_Subscription_to_Transfer to Suspend_Phone_Options No Flow with Survey"
	Then Reinitiate the chat window for other scenario
	
	
	Scenario: SXM Cancel_Subscription_to_Transfer to Suspend_Phone_Options No Flow with Feedback form
	Then Validate AIVA Responses "Hi, I'm the Sirius XM Virtual Agent. I'm here for you!"
	Then Validate AIVA Responses "May I have your first and last name?"
	Then User message is sent successfully ".Keshav Kumar"
	Then Validate AIVA Responses "Thanks, may I also have your phone number, including your area code?"
	Then User message is sent successfully ".9964202472"
	Then Validate AIVA Responses "Thanks, again."
	Then Validate AIVA Responses "How can I help you?"
	Then User message is sent successfully ".I want to suspend my subscription"
	Then Validate AIVA Responses "Chat specialists cannot suspend/hold subscriptions. To suspend your subscription, you must call 888-601-6302."
	Then Validate AIVA Responses "Is there anything else you wish to chat about today?"
	Then Select Quick Response "No"
	Then Validate AIVA Responses "Did that help?"
	Then Select Quick Response "No"
	Then Submit the FeedBack Form
	Then Validate AIVA Responses "Thanks, again."
	Then Validate the AIVA responses "SXM Cancel_Subscription_to_Transfer to Suspend_Phone_Options No Flow with Feedback form"
	Then Reinitiate the chat window for other scenario
	
	Scenario: SXM Refresh Signal Yes flow with Without Input 
	Then Validate AIVA Responses "Hi, I'm the Sirius XM Virtual Agent. I'm here for you!"
	Then Validate AIVA Responses "May I have your first and last name?"
	Then User message is sent successfully ".My radio isn't working."
	Then Validate AIVA Responses "Okay, I may be able to help you with that."
	Then Validate AIVA Responses "Are you near the radio that's having connection problems?"
	Then User message is sent successfully ".YeS"
	Then Validate AIVA Responses "Awesome! What's the radio ID of the radio that's not working, or the phone number on your account?"
	Then User message is sent successfully ".I Dont't know it"
	Then Validate AIVA Resonses "No problem. I'll connect you with a specialist who can help you."
	Then Validate the AIVA responses "SXM Refresh Signal Yes flow with Without Input"
	Then Reinitiate the chat window for other scenario

	Scenario: SXM Refresh Signal Yes flow with Valid Phone Input Yes Clear View Flow
	Then Validate AIVA Responses "Hi, I'm the Sirius XM Virtual Agent. I'm here for you!"
	Then Validate AIVA Responses "May I have your first and last name?"
	Then User message is sent successfully ".My radio isn't working."
	Then Validate AIVA Responses "Okay, I may be able to help you with that."
	Then Validate AIVA Responses "Are you near the radio that's having connection problems?"
	Then User message is sent successfully ".YeS"
	Then Validate AIVA Responses "Awesome! What's the radio ID of the radio that's not working, or the phone number on your account?"
	Then User message is sent successfully ".8811388113"
	Then Validate AIVA Responses "Got it. Does your car or radio have a clear view of the sky? Buildings, large trees and garages may interfere with the signal."
	Then User message is sent successfully ".YeS"
	Then Validate AIVA Responses "Okay, turn your radio on and set it to Channel 1."
	Then Validate AIVA Responses "Do you hear anything?"
	Then User message is sent successfully ".YeS"
	Then Validate AIVA Responses "That's good. Now we'll try to refresh your radio to see if that fixes the issue."
	Then Validate AIVA Responses "Something went wrong and I wasn't able to refresh your radio. Do you want to chat with a specialist who can help you with that?"
	Then Validate the AIVA responses "SXM Refresh Signal Yes flow with Valid Phone Input Yes Clear View Flow"
	Then Reinitiate the chat window for other scenario
	
		Scenario: SXM Refresh Signal Yes flow with InValid Input
	Then Validate AIVA Responses "Hi, I'm the Sirius XM Virtual Agent. I'm here for you!"
	Then Validate AIVA Responses "May I have your first and last name?"
	Then User message is sent successfully ".My radio isn't working."
	Then Validate AIVA Responses "Okay, I may be able to help you with that."
	Then Validate AIVA Responses "Are you near the radio that's having connection problems?"
	Then User message is sent successfully ".YeS"
	Then Validate AIVA Responses "Awesome! What's the radio ID of the radio that's not working, or the phone number on your account?"
	Then User message is sent successfully "000201822412"
	Then Validate AIVA Responses "I don't think that's a valid radio ID or phone number. Please try again and we'll get your favorite programming back ASAP."
	Then User message is sent successfully "000201822412"
	Then Validate AIVA Responses "I'm still not recognizing that as a radio ID or phone number, but I'll connect you with a specialist who can help you."
	Then Validate the AIVA responses "SXM Refresh Signal Yes flow with InValid Input"
	Then Reinitiate the chat window for other scenario

	Scenario: SXM Refresh Signal Yes flow with InValid Input Flow2
	Then Validate AIVA Responses "Hi, I'm the Sirius XM Virtual Agent. I'm here for you!"
	Then Validate AIVA Responses "May I have your first and last name?"
	Then User message is sent successfully ".My radio isn't working."
	Then Validate AIVA Responses "Okay, I may be able to help you with that."
	Then Validate AIVA Responses "Are you near the radio that's having connection problems?"
	Then User message is sent successfully ".YeS"
	Then Validate AIVA Responses "Awesome! What's the radio ID of the radio that's not working, or the phone number on your account?"
	Then User message is sent successfully "000201822412"
	Then Validate AIVA Responses "I don't think that's a valid radio ID or phone number. Please try again and we'll get your favorite programming back ASAP."
	Then User message is sent successfully ".I do not know it"
	Then Validate AIVA Responses "No problem. I'll connect you with a specialist who can help you."
	Then Validate the AIVA responses "SXM Refresh Signal Yes flow with InValid Input Flow 2"
	Then Reinitiate the chat window for other scenario



	Scenario: SXM Refresh Signal No flow With SMS YES
	Then Validate AIVA Responses "Hi, I'm the Sirius XM Virtual Agent. I'm here for you!"
	Then Validate AIVA Responses "May I have your first and last name?"
	Then User message is sent successfully ".My radio isn't working."
	Then Validate AIVA Responses "Okay, I may be able to help you with that."
	Then Validate AIVA Responses "Are you near the radio that's having connection problems?"
	Then User message is sent successfully ".No"
	Then Validate AIVA Responses "No problem. Would you like us to send you a text message with a link that will start the refresh radio process?"
	Then User message is sent successfully ".Yes"
	Then Validate AIVA Responses "Awesome! Text the word "Refresh" to 77917. Just so you know, standard message and data rates may apply. View our"
	Then Submit Wrap Up With Yes
	Then Validate the AIVA responses "SXM Refresh Signal No flow With SMS YES"
	Then Reinitiate the chat window for other scenario

	Scenario: SXM Refresh Signal No flow With SMS No
	Then Validate AIVA Responses "Hi, I'm the Sirius XM Virtual Agent. I'm here for you!"
	Then Validate AIVA Responses "May I have your first and last name?"
	Then User message is sent successfully ".My radio isn't working."
	Then Validate AIVA Responses "Okay, I may be able to help you with that."
	Then Validate AIVA Responses "Are you near the radio that's having connection problems?"
	Then User message is sent successfully ".No"
	Then Validate AIVA Responses "No problem. Would you like us to send you a text message with a link that will start the refresh radio process?"
	Then User message is sent successfully ".No"
	Then Validate AIVA Responses "Okay, when you're near the car or radio that's having connection problems, you can chat with us here, go to"
	Then Submit Wrap Up With No
	Then Validate the AIVA responses "SXM Refresh Signal No flow With SMS No"
	Then Reinitiate the chat window for other scenario