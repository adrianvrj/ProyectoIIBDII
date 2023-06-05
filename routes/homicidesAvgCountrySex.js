const express = require('express');
const homicidesAvgCountrySex = require('../controllers/homicidesAvgCountrySex');
const router = express.Router();

router.get('/', homicidesAvgCountrySex.getHomicidadesAvgCountrySex);


module.exports = router