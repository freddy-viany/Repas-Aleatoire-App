import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

/*
insert font-awesome
*/

import '../node_modules/@fortawesome/fontawesome-free/css/all.css';

/*
insert boostrap
*/

import '../node_modules/bootstrap/dist/css/bootstrap.css';
import "../node_modules/bootstrap/dist/js/bootstrap.bundle";

import '../node_modules/bootstrap-icons/font/bootstrap-icons.css';


createApp(App).use(store).use(router).mount('#app')
