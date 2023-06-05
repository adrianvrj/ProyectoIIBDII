const express = require('express');
const homicidesMinMaxRegionSexoAnioController = require('../controllers/homicidesMinMaxRegionSexoAnio');
const router = express.Router();

router.get('/', homicidesMinMaxRegionSexoAnioController.getHomicidesMinMaxRegionAnio);


module.exports = router