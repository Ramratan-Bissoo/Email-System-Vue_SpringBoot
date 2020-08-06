import axios from "axios";
const state = {
    sentMail:[]
        
};
const getters = {
    allSentMail: state => state.sentMail,
    
   
};
const actions ={
    async getSentMail({commit}, id){
        
    const response = await axios.get("https://spring-vue-email.herokuapp.com/sender/getSentMail/"+id);
    console.log(response.data);
    commit("setSentMail", response.data)
    
  },
  async deleteSentMail({commit}, id){
        
    const response = await axios.delete("https://spring-vue-email.herokuapp.com/sender/DeleteMail/"+id);
    console.log(response.data);
    commit("setDeleteSentMail", response.data)
    
  }

 

  
};
const mutations ={
    setSentMail: (state, mail) => (state.sentMail = mail)
    
    
};

export default{
    state,
    getters,
    actions,
    mutations
}