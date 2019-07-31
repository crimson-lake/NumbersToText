package pl.zielinska.numbers.languages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class ImmutableMapBuilder <S, T> {
	private Map<S, T> map;
	
	ImmutableMapBuilder() {
		map = new HashMap<>();
	}
	
	ImmutableMapBuilder<S, T> put(S key, T value) {
		map.put(key, value);
		return this;
	}
	
	Map<S, T> build() {
		return Collections.unmodifiableMap(map);
	}
}
