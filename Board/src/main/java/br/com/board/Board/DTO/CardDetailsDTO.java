
package br.com.board.Board.DTO;

import java.time.OffsetDateTime;

public class CardDetailsDTO {
    private Long id;
    private String title;
    private String description;
    private OffsetDateTime  blockedAt;
    private String blockReason;
    private String unblockReason;
    private Long boardColumnId;
    private String boardColumnName;
    private Long blockCount;



    public CardDetailsDTO(Long id, String title, String description, OffsetDateTime blockedAt, String blockReason,String unBlockReason, Long boardColumnId, String boardColumnName, Long blockCount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.blockedAt = blockedAt;
        this.blockReason = blockReason;
        this.boardColumnId = boardColumnId;
        this.boardColumnName = boardColumnName;
        this.blockCount = blockCount;
        this.unblockReason =unBlockReason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getUnblockReason() {
        return unblockReason;
    }

    public void setUnblockReason(String unblockReason) {
        this.unblockReason = unblockReason;
    }

    public Long getBoardColumnId() {
        return boardColumnId;
    }

    public void setBoardColumnId(Long boardColumnId) {
        this.boardColumnId = boardColumnId;
    }

    public String getBoardColumnName() {
        return boardColumnName;
    }

    public void setBoardColumnName(String boardColumnName) {
        this.boardColumnName = boardColumnName;
    }

    public Long getBlockCount() {
        return blockCount;
    }

    public void setBlockCount(Long blockCount) {
        this.blockCount = blockCount;
    }
}



