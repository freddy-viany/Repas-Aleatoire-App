import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AddDessertComp from '../components/AddDessertComp'
import AddPlatComp from '../components/AddPlatComp'
import AddEntreeComp from '../components/AddEntreeComp' 
import DisplayMealByWeekComp from '../components/DisplayMealByWeekComp'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/add-dessert',
    name: 'addDessert',
    component: AddDessertComp
  },
  {
    path: '/add-plat',
    name: 'addPlat',
    component: AddPlatComp
  },
  {
    path: '/add-entree',
    name: 'addEntree',
    component: AddEntreeComp
  },
  {
    path: '/display-meal-week',
    name: 'displayMealWeek',
    component: DisplayMealByWeekComp
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
