
if exists('g:vscode')
    so /Users/lihailong/.config/nvim/vscode/vscode.vim
else
    lua require('my-init');
    set encoding=UTF-8
    set cc=80
    " colorscheme abscs
    colorscheme synthwave84
    " colorscheme gruvbox 这里设置的字体和大小
    set guifont=Apercu:h14
    let g:rustfmt_autosave = 1
end 

if exists("g:neovide")
  " g:neovide_transparency should be 0 if you want to unify transparency of content and title bar.
  let g:neovide_transparency=0.0
  let g:transparency = 0.9 
  let g:neovide_background_color = '#0f1117'.printf('%x', float2nr(255 * g:transparency))
  " remember previous window size
  let g:neovide_remember_window_size = v:true
  let g:neovide_cursor_addnimation_length=0
  let g:neovide_cursor_trail_length=0
  let g:neovide_cursor_vfx_mode = ""

endif

