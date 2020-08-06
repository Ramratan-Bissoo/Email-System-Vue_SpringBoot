import axios from "axios";
const state = {
    Profile:[],
    update:[]
   
    
};
const getters = {
    fullProfile: state => state.Profile,
    updateProfile: state => state.update
   
};
const actions ={
    async Set_Profile({commit}, Details){
     console.log(Details)   
      
    const response = await axios.put("https://spring-vue-email.herokuapp.com/api/updateProfile/"+Details.id,Details);
    
    commit("setProfile", response.data)
    
  },

  async Get_Profile({commit}, id){
     
    const response = await axios.get("https://spring-vue-email.herokuapp.com/api/getAccount/"+id);
    commit("getProfile", response.data)
   
  }

  
};
const mutations ={
    getProfile: (state, profile) => (state.Profile = profile),
    setProfile: (state, Update) => (state.update = Update),
    
};

export default{
    state,
    getters,
    actions,
    mutations
}