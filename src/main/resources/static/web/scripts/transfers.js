
const app = Vue.createApp({
    data() {
        return {
            api: "/api/clients/current",
            current: [],
            accounts: [],
            sourceAccount: "",
            destinationAccount:[],
            destinationAccount2: "",
            amount: "",
            description: "",
            my: 1,
                         
          

        }


    },created() {
        
        
       this.loadData(this.api)
       
        
    },methods: {
       
        loadData(api){
            axios.get(api)
            .then(response =>{
                this.current = response.data
                this.accounts =this.current.accounts
            }).catch(function (error) {

                console.error(error);


            });


        },transfer(){

            axios.post('/api/transactions', `amount=${this.amount}&description=${this.description}&originAccountNumber=${this.sourceAccount}&destinationAccountNumber=${this.destinationAccount2}`).then(() => { Swal.fire(
                'Great!',
                'Your transaction has succesfull'
                ), setTimeout(()=>{window.location.assign("./accounts.html")},"2000")
}  ).catch(error => {Swal.fire(error.response.data, '', 'error'); console.log(error);})
            
        },alerta(){
            
            Swal.fire({
                title: 'Are you sure you want to transfer?',
                text: "Check that the data are correct",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, transfer!'
              }).then((result) => {
                if (result.isConfirmed) {

                    this.transfer()

                   

                }
              })
        },


    },computed: {

        destinationAccounts(){

            this.destinationAccount = this.accounts.filter(account => account.number != this.sourceAccount)

        }
    },



}).mount('#app')
