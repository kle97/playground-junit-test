package io.playground.junittest.context;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Builder
@Data
@Setter(AccessLevel.NONE)
public class TestContext {
    
    private String name;
    
    private List<String> types;
}
