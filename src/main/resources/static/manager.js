const overlay = document.getElementById('overlay')

const app = Vue.createApp({
    data() {
      return {
        
          info: null,
          api: "http://localhost:8080/rest/clients",
          clients: [],
          newClientName: "",
          newClientLastName: "",
          newClientEmail: "",
          clienteSelecionado: [],
          editClientName: "",
          editClientLastName: "",
          editClientEmail: "",


  
     
  
      }
    },
    created(){
      this.loadData(this.api) 
      
    },mounted(){
      
        
  
    },
  
  
  
    methods:{

      loadData(url){

        axios
        .get(url)
        .then(response => {
          
          this.info = response
          this.clients = this.info.data._embedded.clients
          


        }).catch( error => { console.log(error);  });

        
        
  
  
      },addClient(){

        if(this.newClientName.length && this.newClientLastName.length && this.newClientEmail) {
  
          let newClient = {nombre:this.newClientName,apellido:this.newClientLastName,email:this.newClientEmail}
          
         
          
          this.postClient(newClient)
          
        }
  
  
      },postClient(newClient){
  
        axios.post(this.api, newClient).then(()=>

        this.loadData(this.api)

        )
          

        

        
  
      },deleteClient(cliente){
        
      
        axios.delete(cliente._links.client.href).then(()=>

          this.loadData(this.api)
          
        )
        

      },editClient(){

        
        
        axios.put(this.clienteSelecionado._links.client.href , {nombre: this.editClientName, apellido: this.editClientLastName, email: this.editClientEmail}).then(()=>{

          this.loadData(this.api)
        
        })

        document.getElementById('overlay').classList.add('active')

        console.log(cliente._links.client.href);


      },editPopUp(cliente){

        document.getElementById('overlay').classList.remove('active')
        console.log(cliente);
        this.editClientName = cliente.nombre
        this.editClientLastName = cliente.apellido
        this.editClientEmail = cliente.email
        this.clienteSelecionado = cliente



      },
      removePopUp(){

        

        document.getElementById('overlay').classList.add('active')

      },


  
    },
    computed:{

      
  
  
    }
  
  }).mount('#app')
  