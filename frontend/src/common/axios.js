import axios from 'axios';

export default axios.create({
  baseURL: "http://localhost:8080/api",
  headers: {
    "Access-Control-Allow-Origin": "*",
    "Content-Type": "application/json; charset = utf-8",
    // "Access-Control-Allow-Credentials": true,
    // "withCredentials" : true,
  },
});
