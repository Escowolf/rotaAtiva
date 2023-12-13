// Import the functions you need from the SDKs you need

import { initializeApp } from "firebase/app";

import { getAnalytics } from "firebase/analytics";

// TODO: Add SDKs for Firebase products that you want to use

// https://firebase.google.com/docs/web/setup#available-libraries


// Your web app's Firebase configuration

// For Firebase JS SDK v7.20.0 and later, measurementId is optional

const firebaseConfig = {

    apiKey: "AIzaSyDqGLWeMTem2l7Sy4t31gTwSqMWR494YuA",
    authDomain: "rota-ativa-pads.firebaseapp.com",
    databaseURL: "https://rota-ativa-pads-default-rtdb.firebaseio.com",
    projectId: "rota-ativa-pads",
    storageBucket: "rota-ativa-pads.appspot.com",
    messagingSenderId: "108611398752",
    appId: "1:108611398752:web:92ff580a7740f6ab6b6705",
    measurementId: "G-TQH7SDX947"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);