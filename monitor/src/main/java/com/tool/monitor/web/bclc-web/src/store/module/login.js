const state ={
  isLogin:false,
  // userName:''
};

const getters = {
  getUserName(state){
    if (!state.isLogin){
      state.userName=sessionStorage.getItem('userName')
    }
    return sessionStorage.getItem('userName')
  },
  // isLogin(state){
  //   if (!state.isLogin){
  //     state.isLogin=sessionStorage.getItem('isLogin')
  //   }
  //   return sessionStorage.getItem('isLogin')
  // },

  isAuthenticated(state){
    if (!state.isAuthenticated){
      state.isAuthenticated=sessionStorage.getItem('isAuthenticated')
    }
    return sessionStorage.getItem('isAuthenticated')
  },
};

const mutations = {
  userLogin (state,data){
    state.isLogin = true;
    // state.userName = data.;
    sessionStorage.setItem('userName',data);    //把用户名和登录状态存储到sessionStorage
    // sessionStorage.setItem('isLogin',true);
    sessionStorage.setItem('isAuthenticated', true);
    // sessionStorage.setItem('userData', data)
  },
  userLogout(state){
    state.isLogin = false;
    // state.userName = '';
    sessionStorage.clear();
    // sessionStorage.removeItem('userName');    //移除sessionStorage
    // sessionStorage.removeItem('isLogin');

  }
};

const actions = {
  login ({commit},userData){
    commit('userLogin',userData);    //引用userStatus方法，并传值
  },
  logout({commit},status){
    commit('userLogout',status)
  }
};

export default {
  state,
  getters,
  mutations,
  actions
}
