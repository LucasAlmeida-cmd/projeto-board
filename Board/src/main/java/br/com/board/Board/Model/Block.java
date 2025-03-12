package br.com.board.Board.Model;

import jakarta.persistence.*;


import java.time.OffsetDateTime;
import java.util.Calendar;

@Entity
@Table(name = "BLOCKS")
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "blocked_at")
    private OffsetDateTime blockedAt;

    @Column(name = "block_reason")
    private String blockReason;

    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime unblockedAt;

    private String unblockReason;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private CardModel card;

    public Block() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getBlockedAt() {
        return blockedAt;
    }

    public void setBlockedAt(OffsetDateTime blockedAt) {
        this.blockedAt = blockedAt;
    }

    public String getBlockReason() {
        return blockReason;
    }

    public void setBlockReason(String blockReason) {
        this.blockReason = blockReason;
    }

    public OffsetDateTime getUnblockedAt() {
        return unblockedAt;
    }

    public void setUnblockedAt(OffsetDateTime unblockedAt) {
        this.unblockedAt = unblockedAt;
    }

    public String getUnblockReason() {
        return unblockReason;
    }

    public void setUnblockReason(String unblockReason) {
        this.unblockReason = unblockReason;
    }

    public CardModel getCard() {
        return card;
    }

    public void setCard(CardModel card) {
        this.card = card;
    }
}




