package com.example.cryptoapp.service;

import com.example.cryptoapp.misc.ConsoleColors;
import com.example.cryptoapp.misc.Statistics;
import com.example.cryptoapp.model.CryptoDTO;
import com.example.cryptoapp.model.response.Base;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;
import java.util.Objects;
import java.util.TimerTask;

@Service
public class CryptoService extends TimerTask {

    private final  String baseURL;
    private final  HttpHeaders headers;
    private final  RestTemplate restTemplate;

    public CryptoService (String baseURL, HttpHeaders headers, RestTemplate restTemplate) {
        this.baseURL = baseURL;
        this.headers = headers;
        this.restTemplate = restTemplate;
    }

    public CryptoDTO getCryptocurrency (String cryptocurrency) {
        cryptocurrency = cryptocurrency.toLowerCase(Locale.ROOT);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Base> response = restTemplate.exchange(baseURL + cryptocurrency, HttpMethod.GET, entity, Base.class);
        return createCryptoDTO(response.getBody());
    }

    public CryptoDTO createCryptoDTO (Base base) {
        CryptoDTO cryptoDTO = new CryptoDTO();
        cryptoDTO.setName(base.data.id.name);
        cryptoDTO.setTag(base.data.id.symbol);
        cryptoDTO.setUsdPrice(base.data.id.quote.usd.price);
        managePrices(cryptoDTO);
        generateStatistic(cryptoDTO);
        return cryptoDTO;
    }

    public void generateStatistic (CryptoDTO cryptoDTO) {
        System.out.println("\n" + ConsoleColors.WHITE_BOLD + "- - - - - " + ConsoleColors.WHITE + "Update #" + Statistics.update + ConsoleColors.WHITE_BOLD + " - - - - -" + ConsoleColors.RESET);
        System.out.println("Name: " + cryptoDTO.getName() + "\n" + "Tag: " + cryptoDTO.getTag() + "\n" + "Current price: " + String.format("%.2f", cryptoDTO.getUsdPrice()) + " US$");
        if (Statistics.last != 0.0) {
            double updateDiff, firstDiff;
            System.out.println("Last price: " + String.format("%.2f",Statistics.last) + " US$" + "\n" + "\n" + "Max price was: " + String.format("%.2f",Statistics.max) + " US$" +"\n" + "Min price was: " + String.format("%.2f",Statistics.min) + " US$" + "\n");
            if (cryptoDTO.getUsdPrice() > Statistics.last) {
                updateDiff = cryptoDTO.getUsdPrice() - Statistics.last;
                System.out.println("Price " + ConsoleColors.GREEN_BOLD + "increased " + ConsoleColors.RESET + "by " + ConsoleColors.GREEN_BOLD + String.format("%.2f",updateDiff) + " US$" + ConsoleColors.RESET + " from last update");
            } else {
                if (cryptoDTO.getUsdPrice() < Statistics.last) {
                    updateDiff = Statistics.last - cryptoDTO.getUsdPrice();
                    System.out.println("Price " + ConsoleColors.RED_BOLD + "dropped " + ConsoleColors.RESET + "by " + ConsoleColors.RED_BOLD + String.format("%.2f", updateDiff) + " US$" + ConsoleColors.RESET + " from last update");
                } else {
                    System.out.println("Price " + ConsoleColors.YELLOW_BOLD + "unchanged " + ConsoleColors.RESET + "(Keep in mind that Coinmarketcap refresh prices every " + ConsoleColors.YELLOW_BOLD + 60 + ConsoleColors.RESET + " seconds only!)");
                }
            }
            if (cryptoDTO.getUsdPrice() > Statistics.first) {
                firstDiff = cryptoDTO.getUsdPrice() - Statistics.first;
                System.out.println("Price " + ConsoleColors.GREEN_BOLD + "increased " + ConsoleColors.RESET + "by " + ConsoleColors.GREEN_BOLD + String.format("%.2f",firstDiff) + " US$" + ConsoleColors.RESET + " from the start of the application");
            } else {
                if (Statistics.first > cryptoDTO.getUsdPrice()) {
                    firstDiff = Statistics.first - cryptoDTO.getUsdPrice() ;
                    System.out.println("Price " + ConsoleColors.RED_BOLD + "dropped " + ConsoleColors.RESET + "by " + ConsoleColors.RED_BOLD + String.format("%.2f",firstDiff) + " US$" + ConsoleColors.RESET + " from the start of the application");
                } else {
                    System.out.println("Price is the " + ConsoleColors.YELLOW_BOLD +  "same" + ConsoleColors.RESET + " as when the application started");
                }
            }
        }
        Statistics.last = cryptoDTO.getUsdPrice();
        Statistics.update++;
    }

    public void managePrices (CryptoDTO cryptoDTO) {
        if (!Objects.equals(Statistics.tag, cryptoDTO.getTag())) {
            System.out.println("\n" + ConsoleColors.CYAN_BOLD + "Change detected: " + ConsoleColors.RESET + "Watching " + cryptoDTO.getName());
            Statistics.tag = cryptoDTO.getTag();
            Statistics.min = cryptoDTO.getUsdPrice();
            Statistics.max = cryptoDTO.getUsdPrice();
            Statistics.last = 0.0;
            Statistics.first = cryptoDTO.getUsdPrice();
        } else {
            if (Statistics.min > cryptoDTO.getUsdPrice()) {
                Statistics.min = cryptoDTO.getUsdPrice();
            } else {
                if (Statistics.max < cryptoDTO.getUsdPrice()) {
                    Statistics.max = cryptoDTO.getUsdPrice();
                }
            }
        }
    }

    @Override
    public void run() {
        getCryptocurrency("Bitcoin");
    }
}
