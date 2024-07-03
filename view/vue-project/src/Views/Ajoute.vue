<template>
  <main>
    <div id="add">
      <form id="form-add" @submit.prevent="addMat">
        <div class="form-group">
          <label for="Design">Design</label>
          <input type="text" id="Design" placeholder="Design" v-model="Design" required />
        </div>
        <div class="form-group">
          <label for="Etat">Etat</label>
          <select id="Etat" v-model="Etat" required>
            <option value="">Choisir l'état</option>
            <option value="Bon">Bon</option>
            <option value="Abimé">Abimé</option>
            <option value="Mauvais">Mauvais</option>
          </select>
        </div>
        <div class="form-group">
          <label for="Quantite">Quantité</label>
          <input type="number" id="Quantite" placeholder="Quantite" v-model="Quantite" required />
        </div>
        <button type="submit" :disabled="!isFormValid" class="btn-submit">Ajouter</button>
      </form>
    </div>
  </main>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      Design: '',
      Etat: '',
      Quantite: ''
    };
  },
  computed: {
    isFormValid() {
      return this.Design !== '' && this.Etat !== '' && this.Quantite !== '';
    }
  },
  methods: {
    async addMat() {
      try {
        await axios.post(`http://10.10.10.11:2000/add_mat`, {
          design: this.Design,
          etat: this.Etat,
          quantite: this.Quantite
        });
        console.log('Form submitted successfully');
        } catch (error) {
          console.error(error);
        }
    }
  }
};
</script>

<style>
  main {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
  }

  #add {
    background-color: #f8f8f8;
    border-radius: 8px;
    padding: 40px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }

  .form-group {
    margin-bottom: 20px;
  }

  label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
  }

  input[type="text"],
  select {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
  }

  input[type="number"] {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
  }

  .btn-submit {
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

  .btn-submit:disabled {
    background-color: #ddd;
    cursor: not-allowed;
  }
</style>
