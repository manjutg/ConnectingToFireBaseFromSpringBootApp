package com.firebase.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.firebase.model.Users;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {
	
	public String saveUserDetails(Users users) throws InterruptedException, ExecutionException {
		
		//establishing connection to Firebase 
		Firestore dbFirestore = FirestoreClient.getFirestore();
		
		//connecting to the collection by name users. 
		//passing username as document id or document id will be auto generated.
		//set function will save value into the collection
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(users.getName()).set(users);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}
	
	public Users getUserDetails(String name) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		
		//Fetching the document id by passing document id 
		DocumentReference documentReferenceId = dbFirestore.collection("users").document(name);
		
		//Getting snapshot of the document
		ApiFuture<DocumentSnapshot> future = documentReferenceId.get();
		DocumentSnapshot document = future.get();
		Users user = null;
		
		if(document.exists()) {
			user = document.toObject(Users.class);
			return user;
		}else {
			return null;
		}
		
	}
	
	public String updateUserDetails(Users users) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(users.getName()).set(users);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}
	
	public String deleteuser(String name) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(name).delete();
		return "user by user name "+name+" is deleted successfully";
	}

}
