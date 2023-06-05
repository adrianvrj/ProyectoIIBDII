const express = require('express');
const homicidesMinMaxRegionSexoDecadaController = require('../controllers/homicidesMinMaxRegionSexoDecada');
const router = express.Router();

router.get('/', homicidesMinMaxRegionSexoDecadaController.getHomicidesMinMaxRegionDecada);


module.exports = router