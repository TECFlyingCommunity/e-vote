import store from '../store';


export default async (to, from, next) => {
  document.title = `${to.name} - Evoto`

  if (to.name !== 'Login' && to.name !== 'Cadastro' && !store.getters.hasToken) {
    try {
      await store.dispatch('ActionCheckToken')

      next({ path: to.path })
    } catch (err) {
      next({ name: 'Login' })
    }
  } else {
    if (to.name === 'login' && store.getters.hasToken) {
      next({ name: 'Home' })
    } else {
      next()
    }
  }
}