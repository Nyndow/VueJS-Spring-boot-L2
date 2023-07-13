<script>
import axios from 'axios';
export default {
    data() {
        return {
            Materiels: [],
            editForm: {},
            showDiv: false,

        }
    },
    methods: {
        deleteRequest(num_materiel) {
            axios
                .delete(`http://localhost:8000/delete_mat/${num_materiel}`)
                .then((response) => {
                    console.log(response);
                    this.fetchMateriels(); // Refresh the Materiels list after successful deletion
                })
                .catch((error) => {
                    console.error('Error deleting Materiel:', error);
                });
        },
        async editMat(mat) {
            this.editForm = { ...mat };
            this.showDiv = true; // Show the form when editing a material
        },
        updateMat() {
            const updatedData = {
                num_materiel: this.editForm.num_materiel,
                design: this.editForm.design,
                etat: this.editForm.etat,
                quantite: this.editForm.quantite,
            };

            axios
                .put(`http://localhost:8000/edit_mat/${this.editForm.num_materiel}`, updatedData)
                .then((response) => {
                    console.log(response);
                    this.fetchMateriels();
                    this.editForm = {};
                    this.showDiv = false; 
                })
                .catch((error) => {
                    alert('Error updating Materiel:', error);
                });
        },
        fetchMateriels() {
            axios
                .get('http://localhost:8000/list_mat')
                .then((response) => {
                    this.Materiels = response.data;
                })
                .catch((error) => {
                    console.error('Error fetching Materiels:', error);
                });
        },

        getEtatCount(etatValue) {
      return this.Materiels
        .filter((mat) => mat.etat === etatValue)
        .reduce((total, mat) => total + mat.quantite, 0);
    },

    getTotalQuantity() {
      return this.Materiels.reduce((total, mat) => total + mat.quantite, 0);
    },

    },
    mounted() {
        this.fetchMateriels();
    },

}
</script>

<template>
    <div class="about">
      <div class="ajouter">
        <button><router-link to="/Ajoute">Ajouter</router-link></button>
        <router-view></router-view>
      </div>
      <table class="table">
        <thead>
          <tr>
            <th>N°matériel</th>
            <th>Design</th>
            <th>Etat</th>
            <th>Quantité</th>
            <th>Supprimer</th>
            <th>Modifier</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="mat in Materiels" :key="mat.num_materiel">
            <td>{{ mat.num_materiel }}</td>
            <td>{{ mat.design }}</td>
            <td>{{ mat.etat }}</td>
            <td>{{ mat.quantite }}</td>
            <td class="btn-cell"><button @click="editMat(mat)" class="btn-edit">Modifier</button></td>
            <td class="btn-cell"><button @click="deleteRequest(mat.num_materiel)" type="button" class="btn-delete">Supprimer</button></td>
          </tr>
        </tbody>
      </table>
      <div v-show="showDiv">
        <form class="edit-form">
          <div class="form-group">
            <label for="Design">Design</label>
            <input type="text" id="Design" v-model="editForm.design" class="form-input" />
          </div>
          <div class="form-group">
            <label for="Etat">Etat</label>
            <select id="Etat" v-model="editForm.etat" class="form-select">
              <option value="Bon">Bon</option>
              <option value="Mauvais">Mauvais</option>
              <option value="Abimé">Abimé</option>
            </select>
          </div>
          <div class="form-group">
            <label for="Quantite">Quantite</label>
            <input type="number" id="Quantite" v-model="editForm.quantite" class="form-input" />
          </div>
          <button @click="updateMat" type="button" class="btn-update">Update</button>
        </form>
      </div>
      <br>
      <br>
      <div class="count-container">
        <div class="count-item">
          <span class="count-label">Total Bon:</span>
          <span class="count-value">{{ getEtatCount('Bon') }}</span>
        </div>
        <div class="count-item">
          <span class="count-label">Total Mauvais:</span>
          <span class="count-value">{{ getEtatCount('Mauvais') }}</span>
        </div>
        <div class="count-item">
          <span class="count-label">Total Abimé:</span>
          <span class="count-value">{{ getEtatCount('Abimé') }}</span>
        </div>
        <div class="count-item">
          <span class="count-label">Total Matériels:</span>
          <span class="count-value">{{ getTotalQuantity() }}</span>
        </div>
      </div>
    </div>
  </template>
  
  <style>
    .about {
      margin-top: 1%;
      font-size: 24px; 
    }
  
    .ajouter {
      margin-bottom: 20px;
      margin-left: 1025px;
    }
  
    table {
      width: 100%;
      border-collapse: collapse;
      font-size: 18px;
      margin-bottom: 20px;
    }
  
    th, td {
      text-align: center;
      border-bottom: 2px #f8f8f8 solid;
      padding: 10px;
    }
  
    .btn-delete, .btn-edit {
      color: rgb(164, 189, 0);
      transition: 0.4s;
      font-size: 18px; 
      background-color: transparent;
      border: none;
      cursor: pointer;
    }
  
    .btn-delete:hover, .btn-edit:hover {
      color: #fff;
    }
  
    .btn-cell {
      padding: 0;
    }
  
    .edit-form {
      margin-top: 20px;
    }
  
    .form-group {
      margin-bottom: 15px;
    }
  
    .form-input, .form-select {
      width: 100%;
      padding: 8px;
      font-size: 14px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
  
    .btn-update {
      display: block;
      width: 100%;
      padding: 10px;
      font-size: 16px;
      background-color: #4caf50;
      color: #fff;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }
  
    .btn-update:hover {
      background-color: #45a049;
    }
  
    .count-container {
      display: flex;
      justify-content: space-between;
      font-size: 18px;
      margin-bottom: 5%;
    }
  
    .count-item {
      display: flex;
      align-items: center;
    }
  
    .count-label {
      margin-right: 10px;
    }
  
    .count-value {
      font-weight: bold;
    }
  </style>
  