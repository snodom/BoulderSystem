import axios from 'axios';
import session from '../session';

const baseUrl = `/api/pockets`;



export default {

    getBoulderList() {
        
        return axios.get('http://localhost:7777/boulder/getAllBoulders');
        
    }, 

    buildFormData(formData, data, parentKey)  {
      if (data && typeof data === 'object' && !(data instanceof Date) && !(data instanceof File)) {
            Object.keys(data).forEach(key => {
              this.buildFormData(formData, data[key], parentKey ? `${parentKey}[${key}]` : key);
            });
      } else {
            const value = data == null ? '' : data;

            formData.append(parentKey, value);
      }
    },

    jsonToFormData(data) {
    
        const formData = new FormData();
  
        this.buildFormData(formData, data);
  
    return formData;
},

    savePocket(data, parse) {

        return axios.post("http://localhost:7777/boulder/addBoulder",this.jsonToFormData(data));

    },

    displayBoulder(id) {
        let data = {idBoulder: id};
        return axios.post("http://localhost:7777/boulder/displayBoulder",this.jsonToFormData(data));

    },


}