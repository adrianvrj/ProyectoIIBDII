const express = require('express');
const app = express();
const path = require('path');
const port = 9000;
var cors = require('cors');
app.use(cors());

var decade_router = require('./routes/decade_poblation');
var fertilityRateRouter = require('./routes/fertitlity_rate_country_decade');
var getJobs = require('./routes/getAllJobs');
var fatalityBirthDecadeCountryRouter = require('./routes/fatalityBirthDecadeCountry');
var fertilityDecadeCountryRouter = require('./routes/fertilityDecadeCountry');
var homicidesAvgCountryRouter = require('./routes/homicidesAvgCountry');
var homicidesAvgCountrySexRouter = require('./routes/homicidesAvgCountrySex');
var lifeExpectancyBirthDecadeRouter = require('./routes/lifeExpectancyBirthDecade');

var communicableDeathsRouter = require('./routes/communicableDeaths');
var homicidesMinMaxRegionRouter = require('./routes/homicidesMinMaxRegion');
var homicidesMinMaxRegionSexoAnioRouter = require('./routes/homicidesMinMaxRegionSexoAnio');
var homicidesMinMaxRegionSexoDecadaRouter = require('./routes/homicidesMinMaxRegionSexoDecada');
var homicidesMinMaxSubregionRouter = require('./routes/homicidesMinMaxSubregion');
var homicidesMinMaxSubregionSexoAnioRouter = require('./routes/homicidesMinMaxSubregionSexoAnio');
var homicidesMinMaxSubregionSexoDecadaRouter = require('./routes/homicidesMinMaxSubregionSexoDecada');
var injuriesDeathsRouter = require('./routes/injuriesDeaths');
var uncommunicableDeathsRouter = require('./routes/uncommunicableDeaths');

var ageGapRouter = require('./routes/ageGap');
var fertilityRateDecadeCountryQuintilRouter = require('./routes/fertilityRateDecadeCountryQuintil');
var fatalityBirthDecadeCountryQuintilRouter = require('./routes/fatalityBirthDecadeCountryQuintil');

const MySqlConsultor = require('./db_connection/mysql');
const mysqlcons = new MySqlConsultor();

app.use(express.json());
app.use(express.urlencoded({extended:true}));
app.use('/decadePoblation', decade_router);
app.use('/fertilityRate', fertilityRateRouter);
app.use('/getJobs', getJobs);
app.use('/fatalityBirthDecadeCountry', fatalityBirthDecadeCountryRouter);
app.use('/fertilityDecadeCountry', fertilityDecadeCountryRouter);
app.use('/homicidesAvgCountry', homicidesAvgCountryRouter);
app.use('/homicidesAvgCountrySex', homicidesAvgCountrySexRouter);
app.use('/lifeExpectancyBirthDecade', lifeExpectancyBirthDecadeRouter);

app.use('/communicableDeaths', communicableDeathsRouter);
app.use('/homicidesMinMaxRegion', homicidesMinMaxRegionRouter);
app.use('/homicidesMinMaxRegionSexoAnio', homicidesMinMaxRegionSexoAnioRouter);
app.use('/homicidesMinMaxRegionSexoDecada', homicidesMinMaxRegionSexoDecadaRouter);
app.use('/homicidesMinMaxSubregion', homicidesMinMaxSubregionRouter);
app.use('/homicidesMinMaxSubregionSexoAnio', homicidesMinMaxSubregionSexoAnioRouter);
app.use('/homicidesMinMaxSubregionSexoDecada', homicidesMinMaxSubregionSexoDecadaRouter);
app.use('/injuriesDeaths', injuriesDeathsRouter);
app.use('/uncommunicableDeaths', uncommunicableDeathsRouter);


app.use('/ageGap', ageGapRouter);
app.use('/fertilityRateDecadeCountryQuintil', fertilityRateDecadeCountryQuintilRouter);
app.use('/fatalityBirthDecadeCountryQuintil', fatalityBirthDecadeCountryQuintilRouter);

app.listen(port, () => {
  console.log(`Conexion establecida`);
});
