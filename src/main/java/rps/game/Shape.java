package rps.game;

public enum Shape {
	Rock {

		@Override
		public boolean beats(Shape other) {
			return other == Scissor;
		}
	},
	Paper {
		@Override
		public boolean beats(Shape other) {
			return other == Rock;
		}
	},
	Scissor {
		@Override
		public boolean beats(Shape other) {
			return other == Paper;
		}
	};

	public abstract boolean beats(Shape other);
}
