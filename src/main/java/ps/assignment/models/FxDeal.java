package ps.assignment.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
public class FxDeal {
    @Id
    @NotBlank(message = "Deal Unique ID is required")
    private String dealUniqueId;

    @NotBlank(message = "From Currency ISO Code is required")
    @Size(min = 3, max = 3, message = "From Currency ISO Code must be 3 characters")
    private String fromCurrencyIsoCode;

    @NotBlank(message = "To Currency ISO Code is required")
    @Size(min = 3, max = 3, message = "To Currency ISO Code must be 3 characters")
    private String toCurrencyIsoCode;

    @NotNull(message = "Deal Timestamp is required")
    private Date dealTimestamp;

    @NotNull(message = "Deal Amount is required")
    @Positive(message = "Deal Amount must be positive")
    private Double dealAmount;

    public FxDeal() {
    }
    public FxDeal(String dealUniqueId, String fromCurrencyIsoCode, String toCurrencyIsoCode, Date dealTimestamp, Double dealAmount) {
        this.dealUniqueId = dealUniqueId;
        this.fromCurrencyIsoCode = fromCurrencyIsoCode;
        this.toCurrencyIsoCode = toCurrencyIsoCode;
        this.dealTimestamp = dealTimestamp;
        this.dealAmount = dealAmount;
    }
}
