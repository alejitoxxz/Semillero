'use strict';
const webSocketUrl = "ws://localhost:8080/chat-back-end";
const client = new StompJs.Client({brockerURL: webSocketUrl})
let buttonSendMessage;
let sectionMessagesExchanged;
let bittonConnectToChat;
let buttonDisconnectToChat;

window.addEventListener(
	'load', () =>{
		buttonSendMessage = document.getElementById("senMessageButton");
		sectionMessagesExchanged = document.getElementById("sectionMessagesExchanged")
		bittonConnectToChat = document.getElementById("ConnectToChatButton")
		buttonDisconnectToChat = document.getElementById("DisconnectToChatButton")
		buttonSendMessage.disabled = true;
	}
);

function connect(){
	client.activate();
	buttonSendMessage.disabled = false;
	bittonConnectToChat.disabled = true;
	buttonDisconnectToChat.disabled = false;
	clearMessageExchanged();
}

function disconnect(){
	client.deactivate();
	buttonSendMessage.disabled = true;
	bittonConnectToChat.disabled = false;
	buttonDisconnectToChat.disabled = true;
	clearMessageExchanged();
}

function clearMessageExchanged(){
	sectionMessageExtchanged.innerHTML = "	<tr ><td colspan='2'>Empty!</td></tr>"
}