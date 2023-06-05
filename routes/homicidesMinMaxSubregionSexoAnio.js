const express = require('express');
const homicidesMinMaxSubregionSexoAnioController = require('../controllers/homicidesMinMaxSubregionSexoAnio');
const router = express.Router();

router.get('/', homicidesMinMaxSubregionSexoAnioController.getHomicidesMinMaxSubregionSexoAnio);


module.exports = router