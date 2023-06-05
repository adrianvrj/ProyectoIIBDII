const express = require('express');
const homicidesAvgCountry = require('../controllers/homicidesAvgCountry');
const router = express.Router();

router.get('/', homicidesAvgCountry.getHomicidadesAvgCountry);


module.exports = router