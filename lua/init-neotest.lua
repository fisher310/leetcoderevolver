require("neodev").setup({
  library = { plugins = { "neotest" }, types = true },
})
require("neotest").setup({
  adapters = {
    require("neotest-rust") {
        args = { "--no-capture" },
    }
  }
})
