<script>
import axios from 'axios';
export default {
    data() {
        return {
            Materiels: [],
            mat:{
            design: '',
            etat: '',
            quantite: ''
            }
        }
    },
    methods: {
        modMat: async function (num_materiel) {
            await axios.put(`http://10.10.10.11:2000/`+ mat.num_materiel, {
                num_materiel: mat.num_materiel,
                design: this.design,
                etat: this.etat,
                quantite: this.quantite
            }).then(response => {
                console.log(response.status)
            }).catch(error => {
                console.error(error)
            })
        }
    }
}

</script>

<template>
    <main>
        <div id="add">
            <form id="form-add">

                <label for="Design">Design</label> <br>
                <input type="text" placeholder="Design" id="Design" v-model="mat.design" required /> <br>
                
                <label for="Etat">Etat</label> <br>
        <select id="Etat" v-model="mat.etat" required>
          <option value="Bon">Bon</option>
          <option value="Mauvais">Mauvais</option>
          <option value="Abimé">Abimé</option>
        </select> <br>

                <label for="Quantite">Quantite</label> <br>
                <input type="number" id="Quantite" placeholder="Quantite" v-model="mat.quantite" required /> <br>

                <button @click="modMat" type="button">Modifier</button>
            </form>
        </div>
    </main>
</template>