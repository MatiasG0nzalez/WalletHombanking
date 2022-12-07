
const app = Vue.createApp({
    data() {
        return {
            login:{
                email: "",
                password: ""
            },

            register: {
                firstName: "",
                lastName: "",
                email: "",
                password: ""
            }


        }


    },created() {
        
        
       
       
        
    },methods: {
       
        signIn(){

            axios.post('/api/login', `email=${this.login.email}&password=${this.login.password}`).then( () => window.location.assign("./accounts.html"))

        },
        signUp(){

            axios.post("/api/clients", `firstName=${this.register.firstName}&lastName=${this.register.lastName}&email=${this.register.email}&password=${this.register.password}`)
            .then( () => 

                
                axios.post('/api/login', `email=${this.register.email}&password=${this.register.password}`).then( () => window.location.assign("./accounts.html"))
                
            )
            
            
        },


       

            
           
        



    }



}).mount('#app')
