import axios from "axios";
const state = {
    products:[],
    login:[]
   
    
};
const getters = {
    allProducts: state => state.products,
    loginData: state => state.login
   
};
const actions ={
    async Sign_Up({commit}, Details){
        const us = Details.password;
      console.log(us);
    const response = await axios.post("https://spring-vue-email.herokuapp.com/api/register",Details);
    
    commit("setProducts", response.data)
    
  },

  async Sign_In({commit}, Details){
      
    const response = await axios.get("https://spring-vue-email.herokuapp.com/api/getLogin/"+Details.emailId+"/"+Details.password);
    
    
    commit("setLogin", response.data)
   
  }

  
};
const mutations ={
    setProducts: (state, products) => (state.products = products),
    setLogin: (state, login) => (state.login = login),
    
};

export default{
    state,
    getters,
    actions,
    mutations
}