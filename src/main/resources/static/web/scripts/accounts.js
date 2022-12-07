
const app = Vue.createApp({
        
    data() {
        return {
            api: "/api/clients/current",
            current: [],
            accounts: [],                     
            loans: [],



        }


    },created() {
        
        
        this.loadData(this.api);
       
        
    },methods: {
       
        loadData(api){
            axios.get(api)
            .then(response =>{
                this.current = response.data
                this.accounts =this.current.accounts
                this.loans = this.current.loans

            }).catch(function (error) {

                console.error(error);


            });


        },

        miles(numero){

            return new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'ARS' }).format(numero)

          },logout(){

            axios.post('/api/logout', ).then( () => window.location.assign("./index.html"))

        },addAccount(){
            axios.post('/api/clients/current/accounts', ).then( () => this.loadData(this.api))
        }


       

            
           
        



    }



}).mount('#app')
