import { createRouter, createWebHistory } from 'vue-router'
import Form1 from '../components/form1.vue'
import Form2 from '../components/form2.vue'
import Form3 from '../components/form3.vue'

const routes = [
  { path: '/', redirect: '/form1' },
  { path: '/form1', component: Form1 },
  { path: '/form2', component: Form2 },
  { path: '/form3', component: Form3 }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
