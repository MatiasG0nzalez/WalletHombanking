const app = Vue.createApp({
        
    data() {
        return {
            api: "/api/clients/current",
            current: [],
            accounts: [],
            selectedAccount: [],                     
            transactions: [],
            id: new URLSearchParams(location.search).get("id"),
            



        }


    },created() {
        
        
        this.loadData(this.api);
        
    },methods: {
       
        loadData(api){
            axios.get(api)
            .then(response =>{
                this.current = response.data
                this.accounts =this.current.accounts
                this.selectedAccount = this.accounts.find( account => account.id == this.id)
                this.transactions = this.selectedAccount.transactions
                if(this.selectedAccount.length == 0){
                    this.selectedAccount = this.accounts[0]
                }

            }).catch(function (error) {

                console.error(error);


            });


        },

        miles(numero){

            return new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'ARS' }).format(numero)

          },logout(){

            axios.post('/api/logout', ).then( () => window.location.assign("./index.html"))

        }


       

            
           
        



    }



}).mount('#app')
