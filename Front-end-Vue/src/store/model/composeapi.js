import axios from "axios";
const state = {
    send:[]
    
};
const getters = {
    mailSended: state => state.send
    
};
const actions ={
    async Compose_Send({commit}, emaildata){
    const response = await axios.post("https://spring-vue-email.herokuapp.com/receiver/MailSend",emaildata);
    console.log(response.data);
    
    const response1 = await axios.post("https://spring-vue-email.herokuapp.com/sender/MailSend",emaildata);
    console.log(response1.data);
    commit("setCompose", response.data)
    
  }

  
  
};
const mutations ={
    setCompose: (state, email) => (state.send = email)
    
};

export default{
    state,
    getters,
    actions,
    mutations
}