const express = require('express');
const homicidesMinMaxSubregionSexoDecadaController = require('../controllers/homicidesMinMaxSubregionSexoDecada');
const router = express.Router();

router.get('/', homicidesMinMaxSubregionSexoDecadaController.getHomicidesMinMaxSubregionSexoDecada);


module.exports = router