const app = Vue.createApp({
        
    data() {
        return {
            api: "/api/clients/current",
            current: [],
            cards: [],
            type: "",
            color: "",
        
        }


    },created() {
        
        
        this.loadData(this.api);
       
        
    },methods: {
       
        loadData(api){
            axios.get(api)
            .then(response =>{
                this.current = response.data
                this.cards = this.current.cards   
                

            }).catch(function (error) {

                console.error(error);


            });


        }, logout(){

            axios.post('/api/logout', ).then( () => window.location.assign("./index.html"))

        },addCard(){
            axios.post('/api/clients/current/cards', `type=${this.type}&color=${this.color}`).then(() =>this.loadData(this.api))
        }

       


    }



}).mount('#app')