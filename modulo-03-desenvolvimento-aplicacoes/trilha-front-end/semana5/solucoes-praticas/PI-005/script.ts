/* 
APIS USADAS 
P/ CLIMA: https://api.openweathermap.org

*/

async function buscarInformacoesClimaticas() {
  const apiKey: string = '519470a7867522f9b463c4e5b01fd0b3';
  const cidade: string = 'Itabuna';

  try {
    const loadingIndicator = document.getElementById('clima_info');

    //mostra mensagem de carregamento
    if (loadingIndicator) {
      loadingIndicator.innerHTML = '<p style="margin-top: 1rem; font-weight:600">Carregando...</p>';
    }

    const response = await fetch(`https://api.openweathermap.org/data/2.5/weather?q=${cidade},BR&appid=${apiKey}&units=metric`);

    if (!response.ok) {
      throw new Error('Erro na requisição para API do clima');
    }

    const data = await response.json();

    if (data && data.main && data.main.temp !== undefined) {
      if (loadingIndicator) loadingIndicator.textContent = ''; //remove mensagem de carregamento

      mostrarTemperatura(data.main.temp, data.main.temp_min, data.main.temp_max, data.weather[0].description)
    } else {
      throw new Error('Dados do clima não disponíveis');
    }

  } catch (error) {
    console.error('Erro buscaClima:', error);
  }
}

function mostrarTemperatura(temperatura: number, tempMin: number, tempMax: number, clima: string) {
  const divWeatherInfo = document.getElementById('clima_info');

  const temperaturaElement = document.createElement('p');
  temperaturaElement.textContent = `Temperatura: ${temperatura}°C`;

  const temperaturaMin = document.createElement('p');
  temperaturaMin.textContent = `Mínima: ${tempMin}°C`;

  const temperaturaMax = document.createElement('p');
  temperaturaMax.textContent = `Máxima: ${tempMax}°C`;

  const temperaturaClima = document.createElement('p');
  temperaturaClima.textContent = `Clima: ${clima}`;

  if (divWeatherInfo) {
    divWeatherInfo.appendChild(temperaturaElement);
    divWeatherInfo.appendChild(temperaturaMin);
    divWeatherInfo.appendChild(temperaturaMax);
    divWeatherInfo.appendChild(temperaturaClima);
  } else {
    console.error('Div não encontrada.');
  }
}
buscarInformacoesClimaticas();