import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import { createRouter, createWebHistory } from 'vue-router'
import Materiels from './Views/Materiels.vue'
import Ajoute from './Views/Ajoute.vue'
import modifier from './Views/modifier.vue'
const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: '/Materiels', component: Materiels },
        { path: '/Ajoute', component: Ajoute },
       { path: '/modifier', component: modifier }
    ]
});

createApp(App)
  .use(router)
  .mount('#app');