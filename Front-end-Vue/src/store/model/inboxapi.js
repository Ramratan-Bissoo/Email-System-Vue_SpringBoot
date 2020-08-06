import axios from "axios";
const state = {
    inboxMail:[]
        
};
const getters = {
    allInboxMail: state => state.inboxMail,
    
   
};
const actions ={
    async getInboxMail({commit}, id){
        
    const response = await axios.get("https://spring-vue-email.herokuapp.com/receiver/getInboxMail/"+id);
    console.log(response.data);
    commit("setInboxMail", response.data)
    
  },
  async deleteInboxMail({commit}, id){
        
    const response = await axios.delete("https://spring-vue-email.herokuapp.com/receiver/DeleteMail/"+id);
    console.log(response.data);
    commit("setDeleteInboxMail", response.data)
    
  }

 

  
};
const mutations ={
    setInboxMail: (state, mail) => (state.inboxMail = mail)
    
    
};

export default{
    state,
    getters,
    actions,
    mutations
}